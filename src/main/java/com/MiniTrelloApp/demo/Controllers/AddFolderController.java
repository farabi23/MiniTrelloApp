package com.MiniTrelloApp.demo.Controllers;


import com.MiniTrelloApp.demo.Entities.Folders;
import com.MiniTrelloApp.demo.Repositories.FoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddFolderController {

    @Autowired
    private FoldersRepository foldersRepository;

    @GetMapping("/addFolder")
    public String addFolder() {
        return "addFolder";
    }

    @PostMapping("/addFolder")
    public String addFolder(@RequestParam("folderName") String folderName) {

        Folders folder = new Folders();

        folder.setName(folderName);

        foldersRepository.save(folder);

        return "redirect:/";

    }
}
