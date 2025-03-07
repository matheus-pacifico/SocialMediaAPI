package pacifico.mvm.trailblaze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pacifico.mvm.trailblaze.model.reports.CommentReport;

@Repository
public interface CommentReportRepository extends JpaRepository<CommentReport, Long> {

}
