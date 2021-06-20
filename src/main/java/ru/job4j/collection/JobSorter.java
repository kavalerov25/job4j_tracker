package ru.job4j.collection;

import ru.job4j.collection.Job;
import ru.job4j.collection.SortByNameJob;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
               /* new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1),
                new Job("X task", 0)
                */
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)

        );
        /* System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        Collections.sort(jobs, new SortByNameJob());
        System.out.println(jobs);
        */
      //  Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
      // System.out.println(jobs);
        jobs.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);

        Comparator<Job> compareName = Comparator.comparing(Job::getName);
        Comparator<Job> comparePriority = Comparator.comparingInt(Job::getPriority);
        Comparator<Job> combine = compareName.thenComparing(comparePriority);

        jobs.sort(combine);
    }
}