package com.personal.budgetApp.Scheduler;

import com.personal.budgetApp.Service.BudgetService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class SchedulerComponent {

    private static final Log log = LogFactory.getLog(SchedulerComponent.class);

    private final BudgetService budgetService;

    public SchedulerComponent(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @Scheduled(cron="0 0 0 * * ?")
    public void performReportGenerationTaskDaily() {
        log.info("Executing weekly budget task at: " + LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 1 1 * ?") // Executes every first day of month at 1 AM
    public void performReportGenerationTaskMonthly() {
        log.info("Executing monthly budgeting task executed at: " + LocalDateTime.now());
    }
}
