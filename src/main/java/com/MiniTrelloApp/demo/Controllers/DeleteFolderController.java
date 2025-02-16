package com.MiniTrelloApp.demo.Controllers;

import com.MiniTrelloApp.demo.Repositories.FoldersRepository;
import com.MiniTrelloApp.demo.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteFolderController {

    @Autowired
    private FoldersRepository foldersRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @PostMapping("/deleteFolder/{id}")
    public String deleteFolder(@PathVariable Long id) {

        tasksRepository.deleteByFolderId(id);

        foldersRepository.deleteById(id);


        return "redirect:/";
    }
}
