package com.fpt.soft.controller;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.soft.form.BookingForm;
import com.fpt.soft.model.Booking;
import com.fpt.soft.model.Department;
import com.fpt.soft.service.BookingService;
import com.fpt.soft.service.DepartmentService;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/cancel/{id}")
	public String cancel(@PathVariable(value = "id") int id) {
		Optional<Booking> optBooking = bookingService.findById(id);
		optBooking.get().setStatus(false);
		bookingService.save(optBooking.get());
		sendMail(optBooking.get().getEmail(), "Cancel Booking Sucessful",
				"Booking "+optBooking.get().getName()+"canceled successful in our system.");
		return "redirect:/booking/list";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable(value = "id") int id, Model model) {
		Optional<Booking> optBooking = bookingService.findById(id);
		if (optBooking.isPresent()) {
			model.addAttribute("booking", optBooking.get());
		}
		return "user/infoDetail";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Booking>list= bookingService.findAll();
		model.addAttribute("booking", list);
		return "user/infoBooking";
	}
	
	@GetMapping("/confirm/{id}")
	public String confirm(@PathVariable(value = "id") int id, Model model) {
		Optional<Booking> optBooking = bookingService.findById(id);
		if (optBooking.isPresent()) {
			model.addAttribute("booking", optBooking.get());
		}
		return "user/confirm";
	}
	
	@GetMapping("/{id}")
	public String viewBooking(@PathVariable(value = "id") int id,
			@ModelAttribute("booking") BookingForm bo){
		Optional<Department> optDepart = departmentService.findById(id);
		if (optDepart.isPresent()) {
			bo.setNameDepartment(optDepart.get().getName());
		}
		return "user/booking";
	}
	
	@PostMapping("/save")
	public String save(@Validated @ModelAttribute("booking") BookingForm bo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user/booking";
		}
		Optional<Department> optDepart = departmentService.findDepartmentByName(bo.getNameDepartment());
		try {
			if (bo.getSms().equals("sms")) {
				sendMail(bo.getEmail()+bo.getEmailSub(), "Booking sucessful",
					", Hello "+ bo.getName()+" booked successful in our system.");
			}
		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}

		//set value for booking to save
		Booking b = new Booking(bo.getName(),bo.getPhoneSub()+bo.getPhone(),bo.getMobileSub()+bo.getMobile(), bo.getEmail()+bo.getEmailSub(), 
				bo.getAddress(), bo.getDateStart(),bo.getDateEnd(), new Date(), 
				bo.getPerson(), bo.getContent(),true,optDepart.get());
		Booking boo = bookingService.save(b);
		return "redirect:/booking/confirm/"+boo.getId();
	}

  	public boolean sendMail(String to, String subject,String content) 
  	{ 		 
         Properties properties = new Properties();
         properties.put("mail.smtp.host", "smtp.gmail.com");
         properties.put("mail.smtp.port", "587");
         properties.put("mail.smtp.auth", "true");
         properties.put("mail.smtp.starttls.enable", "true");
         try {
             Authenticator auth = new Authenticator() 
             {
                 public PasswordAuthentication getPasswordAuthentication() 
                 {
                     return new PasswordAuthentication("huytpgde140306@fpt.edu.vn", "01662529468");  // add username and password
                 }
             };
             Session session = Session.getInstance(properties, auth);
             
             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress("huytpgde140306@fpt.edu.vn"));    // add email address        
             message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
             message.setSentDate(new Date());
             message.setSubject(subject);
             message.setText(content); 
             Transport.send(message);	
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
         return true;
  	} 
  	
}
