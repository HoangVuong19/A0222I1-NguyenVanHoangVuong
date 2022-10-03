package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songs", iSongService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String save(Song song, RedirectAttributes redirect){
        song.setId((long) (Math.random()*1000));
        iSongService.save(song);
        redirect.addFlashAttribute("success", "add thành công");
        return "redirect:/song";
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable long id, Model model){
        Song song = iSongService.findById(id);
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long id, RedirectAttributes redirect){
        iSongService.delete(id);
        redirect.addFlashAttribute("success", "xóa thành công");
        return "redirect:/song";
    }
}
