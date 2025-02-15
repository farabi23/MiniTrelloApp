package com.MiniTrelloApp.demo.Controllers;


import com.MiniTrelloApp.demo.Entities.Folders;
import com.MiniTrelloApp.demo.Entities.TaskCategories;
import com.MiniTrelloApp.demo.Repositories.FoldersRepository;
import com.MiniTrelloApp.demo.Repositories.TaskCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddCategoryController {

    @Autowired
    private TaskCategoriesRepository taskCategoriesRepository;

    @Autowired
    private FoldersRepository foldersRepository;

    @PostMapping("/addCategory")
    public String addCategory(@RequestParam("categoryName") List<String> categoryNames,
                              @RequestParam("folderId") Long folderId, Model model) {

       List<TaskCategories> newCats = new ArrayList<>();

        for (String categoryName : categoryNames) {
            TaskCategories taskCategories = new TaskCategories();
            taskCategories.setName(categoryName);
            taskCategoriesRepository.save(taskCategories);
            newCats.add(taskCategories);
        }

        Folders folder = foldersRepository.findById(folderId).orElse(null);
        if (folder != null) {
            folder.setCategories(newCats);
        }
        if (folder != null) {
            foldersRepository.save(folder);
        }


        return "redirect:/detailFolder/" + folderId;
    }
}
