package com.MiniTrelloApp.demo.Repositories;

import com.MiniTrelloApp.demo.Entities.Folders;
import com.MiniTrelloApp.demo.Entities.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskCategoriesRepository extends JpaRepository<TaskCategories, Long> {


}
