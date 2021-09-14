package com.dudin.actnotemanager.controller;

import com.dudin.actnotemanager.model.ActNote;
import com.dudin.actnotemanager.model.MyLocalDate;
import com.dudin.actnotemanager.service.ActNoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/act_note_manager")
public class ActNoteManagerController {

    private final ActNoteServiceImpl service;

    @Autowired
    public ActNoteManagerController(ActNoteServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewActNoteManagerPage(Model model) {
        List<ActNote> listActNotes = service.listAll();
        model.addAttribute("listActNotes", listActNotes);

        return "act_note_manager/act_note_manager";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewActNoteForm(Model model) {
        ActNote actNote = new ActNote();
        actNote.setDateOfRegistration(new MyLocalDate().getMyLocalDate());

        model.addAttribute("actNote", actNote);


        return "act_note_manager/new_act_note";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveActNote(@ModelAttribute("actNote") ActNote actNote) {
        service.save(actNote);

        return "redirect:/act_note_manager";
    }

    @RequestMapping(value = "/id-{id}", method = RequestMethod.GET)
    public ModelAndView showViewActNoteForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("act_note_manager/view_act_note");

        ActNote actNote = service.get(id);
        modelAndView.addObject("actNote", actNote);

        return modelAndView;
    }

    @RequestMapping(value = "/id-{id}/edit", method = RequestMethod.GET)
    public ModelAndView showEditActNoteForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("act_note_manager/edit_act_note");

        ActNote actNote = service.get(id);
        modelAndView.addObject("actNote", actNote);

        return modelAndView;
    }

    @RequestMapping(value = "/id-{id}/delete", method = RequestMethod.GET)
    public String deleteActNote(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/act_note_manager";
    }

}
