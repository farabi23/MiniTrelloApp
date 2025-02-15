package com.MiniTrelloApp.demo.Controllers;

import com.MiniTrelloApp.demo.Entities.Folders;
import com.MiniTrelloApp.demo.Repositories.FoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FolderDetailController {

    @Autowired
    private FoldersRepository foldersRepository;

    @GetMapping("/detailFolder/{id}")
    public String detailFolder(@PathVariable Long id, Model model) {

        Folders folder = foldersRepository.findById(id).orElse(null);

        model.addAttribute("folder", folder);
        model.addAttribute("id", id);



        return "detailFolder";

    }
}
