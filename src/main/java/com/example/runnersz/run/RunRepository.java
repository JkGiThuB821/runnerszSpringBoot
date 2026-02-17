package com.example.runnersz.run;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.print.attribute.standard.RequestingUserName;
import org.springframework.stereotype.Repository;

@Repository
public class RunRepository {

  private List<Run> runs = new ArrayList<>();

  List<Run> findAll() {
    return runs;
  }

  Optional<Run> findById(Integer id) {
    return runs.stream()
            .filter(r -> r.id().equals(id))
            .findFirst();
  }

  void create(Run run) {
    runs.add(run);
  }

  void update(Run run, Integer id) {
    Optional<Run> existingRun = findById(id);
    if(existingRun.isPresent()) {
      runs.set(runs.indexOf(existingRun.get()),run );
    }
  }

  void delete(Integer id) {
    Optional<Run> existingRun = findById(id);
    existingRun.ifPresent(runs::remove);
  }

  @PostConstruct
  private void init() {
    runs.add(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), Location.OUTDOOR));
    runs.add(new Run(2, "Evening Run", LocalDateTime.now(), LocalDateTime.now().plus(60, ChronoUnit.MINUTES), Location.INDOOR));
  }

}
