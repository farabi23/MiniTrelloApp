package com.MiniTrelloApp.demo.Controllers;

import com.MiniTrelloApp.demo.Entities.Folders;
import com.MiniTrelloApp.demo.Entities.Tasks;
import com.MiniTrelloApp.demo.Repositories.FoldersRepository;
import com.MiniTrelloApp.demo.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FolderDetailController {

    @Autowired
    private FoldersRepository foldersRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/detailFolder/{id}")
    public String detailFolder(@PathVariable Long id, Model model) {

        Folders folder = foldersRepository.findById(id).orElse(null);
        // This will fetch only tasks where task.folder.id equals the provided id
        List<Tasks> taskList = tasksRepository.findByFolderId(id);

        model.addAttribute("taskList", taskList);
        model.addAttribute("folder", folder);
        model.addAttribute("id", id);

        return "detailFolder";

    }
}
