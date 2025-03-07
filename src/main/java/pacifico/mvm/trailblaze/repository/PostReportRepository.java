package pacifico.mvm.trailblaze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pacifico.mvm.trailblaze.model.reports.PostReport;

@Repository
public interface PostReportRepository extends JpaRepository<PostReport, Long> {

}
