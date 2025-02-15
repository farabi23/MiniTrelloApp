package com.MiniTrelloApp.demo.Repositories;

import com.MiniTrelloApp.demo.Entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TasksRepository  extends JpaRepository<Tasks, Long> {
}
