package com.MiniTrelloApp.demo.Controllers;

import com.MiniTrelloApp.demo.Entities.Folders;
import com.MiniTrelloApp.demo.Repositories.FoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private FoldersRepository foldersRepository;

    @GetMapping("/")
    public String mainPage(Model model) {

        List<Folders> folderList = foldersRepository.findAll();

        model.addAttribute("folderList", folderList);

        return "main";
    }
}
