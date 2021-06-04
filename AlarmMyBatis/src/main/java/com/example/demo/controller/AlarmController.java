package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mapper.AlarmMapper;
import com.example.demo.mapper.HistoryMapper;
import com.example.demo.model.Alarm;
import com.example.demo.model.History;

@Controller
public class AlarmController {

	@Autowired
	AlarmMapper alarmMapper;
	
	@Autowired
	HistoryMapper historyMapper;

	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable(value = "id") int id, Model model) {
		Alarm alarm = alarmMapper.selectByPrimaryKey(id);
		model.addAttribute("alarm", alarm);
		return "alarm";
	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute("alarm") Alarm alarm, Model model) {
		String str = "";
		Alarm oldAlarm = alarmMapper.selectByPrimaryKey(alarm.getId());
		if (alarm.getIntitalNotificationEvacuation().equals(oldAlarm.getIntitalNotificationEvacuation()) == false) {
			str += "Intital Notification Old: " + oldAlarm.getIntitalNotificationEvacuation() + " =>New: "
					+ alarm.getIntitalNotificationEvacuation() + " *** ";
		}
		if (alarm.getEndingNotificationEvacuation().equals(oldAlarm.getEndingNotificationEvacuation()) == false) {
			str += "End Notification Old: " + oldAlarm.getEndingNotificationEvacuation() + " =>New: "
					+ alarm.getEndingNotificationEvacuation() + " *** ";
		}
		if (alarm.getDefaultEvacuationLength().equals(oldAlarm.getDefaultEvacuationLength()) == false) {
			str += "Default Evacuation Length Old: " + oldAlarm.getDefaultEvacuationLength() + " =>New: "
					+ alarm.getDefaultEvacuationLength() + " *** ";
		}

		if (alarm.getManDownNotification().equals(oldAlarm.getManDownNotification()) == false) {
			str += "Man Down Notification Old: " + oldAlarm.getManDownNotification() + " =>New: "
					+ alarm.getManDownNotification() + " *** ";
		}
		if (alarm.getDissappearsAfterMandown().equals(oldAlarm.getDissappearsAfterMandown()) == false) {
			str += "Dissappears After Old: " + oldAlarm.getDissappearsAfterMandown() + " =>New: "
					+ alarm.getDissappearsAfterMandown() + " *** ";
		}
		if (alarm.getManDownMovementTrigger().equals(oldAlarm.getManDownMovementTrigger()) == false) {
			str += "Enable Old: " + oldAlarm.getManDownMovementTrigger() + " =>New: "
					+ alarm.getManDownMovementTrigger() + " *** ";
		}
		if (alarm.getTriggerMovementManDown().equals(oldAlarm.getTriggerMovementManDown()) == false) {
			str += "Trigger No Movement Old: " + oldAlarm.getTriggerMovementManDown() + " =>New: "
					+ alarm.getTriggerMovementManDown() + " *** ";
		}
		if (alarm.getAccelerometerVectorManDown().equals(oldAlarm.getAccelerometerVectorManDown()) == false) {
			str += "Accelerometer Vector Old: " + oldAlarm.getAccelerometerVectorManDown() + " =>New: "
					+ alarm.getAccelerometerVectorManDown() + " *** ";
		}
		try {
			if (alarm.getxAxisExceeds().equals(oldAlarm.getxAxisExceeds()) == false
					|| alarm.getyAxisExceeds().equals(oldAlarm.getyAxisExceeds()) == false
					|| alarm.getzAxisExceeds().equals(oldAlarm.getzAxisExceeds()) == false) {
				str += "X Y Z Axis Exceeds have changed." + " *** ";
			}
		} catch (NullPointerException e) {
		}
		if (alarm.getPanicNotification().equals(oldAlarm.getPanicNotification()) == false) {
			str += "Panic Notification Old: " + oldAlarm.getPanicNotification() + " =>New: "
					+ alarm.getPanicNotification() + " *** ";
		}
		if (alarm.getDissappearsAfterPanic().equals(oldAlarm.getDissappearsAfterPanic()) == false) {
			str += "Dissappears Panic Old: " + oldAlarm.getDissappearsAfterPanic() + " =>New: "
					+ alarm.getDissappearsAfterPanic() + " *** ";
		}
		if (alarm.getDalilyNotification().equals(oldAlarm.getDalilyNotification()) == false) {
			str += "Dalily Notification Old: " + oldAlarm.getDalilyNotification() + " =>New: "
					+ alarm.getDalilyNotification() + " *** ";
		}
		if (alarm.getAlarmResponsePanel().equals(oldAlarm.getAlarmResponsePanel()) == false) {
			str += "Alarm Response Panel Old: " + oldAlarm.getAlarmResponsePanel() + " =>New: "
					+ alarm.getAlarmResponsePanel() + " *** ";
		}
		if (alarm.getZoneBreachTime().equals(oldAlarm.getZoneBreachTime()) == false) {
			str += "Zone Breach Time Old: " + oldAlarm.getZoneBreachTime() + " =>New: "
					+ alarm.getZoneBreachTime() + " *** ";
		}
		if (alarm.getDissappearsAfterZoneBreach().equals(oldAlarm.getDissappearsAfterZoneBreach()) == false) {
			str += "Dissappears Zone Breach Old: " + oldAlarm.getDissappearsAfterZoneBreach() + " =>New: "
					+ alarm.getDissappearsAfterZoneBreach() + " *** ";
		}
		if (alarm.getRemoveFromAlarm().equals(oldAlarm.getRemoveFromAlarm()) == false) {
			str += "Remove From Alarm Old: " + oldAlarm.getRemoveFromAlarm() + " =>New: "
					+ alarm.getRemoveFromAlarm() + " *** ";
		}
		System.out.println(str.length());

		alarmMapper.updateByPrimaryKeySelective(alarm);
		History h = new History(str, new Date(), alarm.getId());
		historyMapper.insertSelective(h);
		model.addAttribute("message", "Updated successful and saved history.");
		return "alarm";
	}

	@GetMapping("/")
	public String viewPage(@ModelAttribute("alarm") Alarm alarm, Model model) {
		model.addAttribute("message", "Welcome to Alarm web"); 
		return "alarm";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("alarm") Alarm alarm, Model model) {
		alarmMapper.insertSelective(alarm);
		model.addAttribute("message", "Saved successful");
		return "alarm";
	}

	@ModelAttribute(name = "list")
	public List<Alarm> getAlarms() {
		return alarmMapper.getAll();
	}
	
	@ModelAttribute(name = "listHistory")
	public List<History> getHistorys() {
		return historyMapper.getAllHistory();
	}
	
}
