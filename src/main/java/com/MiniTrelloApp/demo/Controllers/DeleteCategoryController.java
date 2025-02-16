package com.MiniTrelloApp.demo.Controllers;

import com.MiniTrelloApp.demo.Entities.Folders;
import com.MiniTrelloApp.demo.Entities.TaskCategories;
import com.MiniTrelloApp.demo.Repositories.FoldersRepository;
import com.MiniTrelloApp.demo.Repositories.TaskCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DeleteCategoryController {

    @Autowired
    private TaskCategoriesRepository taskCategoriesRepository;

    @Autowired
    private FoldersRepository foldersRepository;

    @Transactional
    @PostMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id,
                                 @RequestParam("folderId") Long folderId) {

        TaskCategories category = taskCategoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Remove category from all folders
        List<Folders> folders = category.getFolders();
        for (Folders folder : folders) {
            folder.getCategories().remove(category);
            foldersRepository.save(folder);
        }

        // Now delete the category
        taskCategoriesRepository.delete(category);

        return "redirect:/detailFolder/" + folderId;
    }
}
