package com.MiniTrelloApp.demo.Controllers;


import com.MiniTrelloApp.demo.Entities.Folders;
import com.MiniTrelloApp.demo.Entities.Tasks;
import com.MiniTrelloApp.demo.Repositories.FoldersRepository;
import com.MiniTrelloApp.demo.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddTaskController {
    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private FoldersRepository foldersRepository;

    @PostMapping("/addTask")
    public String addTask(@RequestParam("taskName") String taskName,
                          @RequestParam("taskDescription") String taskDescription,
                          @RequestParam("folderId") Long folderId) {

        Folders folder = foldersRepository.findById(folderId).orElse(null);

        Tasks task = new Tasks();
        task.setTitle(taskName);
        task.setDescription(taskDescription);
        task.setStatus(0);
        task.setFolder(folder);
        tasksRepository.save(task);


        return "redirect:/detailFolder/" + folderId;

    }
}
