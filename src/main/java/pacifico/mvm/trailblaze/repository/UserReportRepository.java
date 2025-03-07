package pacifico.mvm.trailblaze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pacifico.mvm.trailblaze.model.reports.UserReport;

public interface UserReportRepository extends JpaRepository<UserReport, Long> {

}
