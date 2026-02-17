package com.example.runnersz.run;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/runs")
public class RunController {

  private final RunRepository runRepository;

  public RunController(RunRepository runRepository) {
    this.runRepository = runRepository;
    //this is where u dont need to initialize the
    // repository because of the @Repository annotation,
    // spring will do it for you and inject it into the constructor
  }

  @GetMapping("")
  List<Run> findAll() {
    return runRepository.findAll();
  }

  //post
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  void create(@RequestBody Run run) {
    runRepository.create(run);
  }

  @GetMapping("/{id}")
  Optional<Run> findById(@PathVariable Integer id) {
    Optional<Run> run = runRepository.findAll().stream()
            .filter(r -> r.id().equals(id))
            .findFirst();
    if(run.isEmpty()) {
      throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Run not found");
    }
    return run;
  }

  //update
  @PutMapping("/{id}")
  void update(@RequestBody Run run, @PathVariable Integer id) {
    runRepository.update(run, id);
  }

  //delete
  @PostMapping("/{id}/delete")
  void delete(@PathVariable Integer id) {
    runRepository.delete(id);
  }
}
