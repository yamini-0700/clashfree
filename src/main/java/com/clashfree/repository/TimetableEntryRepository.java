   package com.clashfree.repository;

   import com.clashfree.entity.TimetableEntry;
   import org.springframework.data.jpa.repository.JpaRepository;

   public interface TimetableEntryRepository extends JpaRepository<TimetableEntry, Long> {

   }