package com.fpt.soft.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.soft.form.DepartmentForm;
import com.fpt.soft.model.Address;
import com.fpt.soft.model.Attachments;
import com.fpt.soft.model.Department;
import com.fpt.soft.model.Images;
import com.fpt.soft.service.AddressService;
import com.fpt.soft.service.AttachmentsService;
import com.fpt.soft.service.DepartmentService;
import com.fpt.soft.service.ImagesService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private ImagesService imagesService;
	@Autowired
	private AttachmentsService attachmentsService;
	@Autowired
	private AddressService addressService;
    
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "name", "asc", model, null);
	}

	@GetMapping("/showEdit/{id}")
	public String showEdit(@PathVariable(value = "id") int id, Model model) {
		Optional<Department> optDepart = departmentService.findById(id);
		if (optDepart.isPresent()) {
			model.addAttribute("department", optDepart.get());
		}
		List<Images> listImage = imagesService.findImagesByDepartmentId(optDepart.get().getId());
		List<Attachments> listFile = attachmentsService.findAttachmentsByDepartmentId(optDepart.get().getId());
		model.addAttribute("listImage", listImage);
		model.addAttribute("listFile", listFile);
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(@Validated @ModelAttribute("department") Department df,@RequestParam("radioName") String radio, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "inforManager";
		}
		System.out.println("Radio name: "+radio);
		if (radio.equals("option1")) {
			System.out.println("Radio name true: ");
			List<Images> list = imagesService.findImagesByDepartmentId(df.getId());
			imagesService.deleteAll(list);
		}
		departmentService.updateDepartment(df);
		return "redirect:/";
	}
	

	@GetMapping("/register")
	public String showNewForm(@ModelAttribute("department") DepartmentForm df) {
		return "inforManager";
	}

	@PostMapping("/save")
	public String save(@Validated @ModelAttribute("department") DepartmentForm df, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "inforManager";
		}
		departmentService.register(df);
		imagesService.register(df);
		attachmentsService.register(df);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") int id) {
		this.departmentService.deleteById(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="/searchAddress", method=RequestMethod.POST)
	public @ResponseBody Address search (@RequestParam String newSearch, ModelMap model)
	{   
		Optional<Address> ad = addressService.findById(Integer.parseInt(newSearch));
		Address result = ad.get();
		System.out.println("Name "+result.getName());
	    model.addAttribute("ok", result.getName());
	    return result;
	}
	
	@GetMapping("/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String name) {
		List<Department> list = departmentService.findByNameLikeOrderByName(name);
		model.addAttribute("list", list);
		return "departments";
	}

	@GetMapping("/detail/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") Integer id) {
		Optional<Department> optDepart = departmentService.findById(id);
		if (optDepart.isPresent()) {
			model.addAttribute("depart", optDepart.get());
		}
		List<Images> listImage = imagesService.findImagesByDepartmentId(optDepart.get().getId());
		List<Attachments> listFile = attachmentsService.findAttachmentsByDepartmentId(optDepart.get().getId());
		model.addAttribute("listImage", listImage);
		model.addAttribute("listFile", listFile);
		return "detail";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model, @Param("keyword") String keyword) {
		int pageSize = 5;

		Page<Department> page = departmentService.findPaginated(pageNo, pageSize, sortField, sortDir, keyword);
		List<Department> list = page.getContent();
		System.out.println("Keyword: " + keyword);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("list", list);
		return "departments";
	}
}
