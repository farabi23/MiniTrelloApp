package com.MiniTrelloApp.demo.Repositories;

import com.MiniTrelloApp.demo.Entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TasksRepository  extends JpaRepository<Tasks, Long> {

    List<Tasks> findByFolderId(Long folderId);

    @Modifying
    @Query("DELETE FROM Tasks t WHERE t.folder.id = :folderId")
    void deleteByFolderId(@Param("folderId") Long folderId);


}
