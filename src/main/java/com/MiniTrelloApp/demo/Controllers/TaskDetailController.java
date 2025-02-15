package com.MiniTrelloApp.demo.Controllers;


import com.MiniTrelloApp.demo.Entities.Tasks;
import com.MiniTrelloApp.demo.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskDetailController {

    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/detailTask/{id}")
    public String detailTask(@PathVariable Long id, Model model) {

        Tasks task = tasksRepository.findById(id).orElse(null);
        Long folderId = task.getFolder().getId();

        model.addAttribute("task", task);
        model.addAttribute("folderId", folderId);

        return "detailTask";

    }

    @PostMapping("/detailTask/{id}")
    public String addTask(@PathVariable Long id,
                          @RequestParam("taskName") String taskName,
                          @RequestParam("taskDescription") String taskDescription,
                          @RequestParam("taskStatus") int taskStatus,
                          @RequestParam("folderId") Long folderId,
                          Model model) {

        Tasks task = tasksRepository.findById(id).orElse(null);
        task.setTitle(taskName);
        task.setDescription(taskDescription);
        task.setStatus(taskStatus);
        tasksRepository.save(task);

        return "redirect:/detailFolder/" + folderId;


    }


}
