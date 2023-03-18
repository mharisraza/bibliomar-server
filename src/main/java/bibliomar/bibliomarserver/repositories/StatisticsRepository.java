package bibliomar.bibliomarserver.repositories;

import bibliomar.bibliomarserver.models.statistics.Statistics;
import bibliomar.bibliomarserver.utils.constants.Topics;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatisticsRepository extends CrudRepository<Statistics, String> {
    public Statistics findByMD5(String MD5);

    public Statistics findByMD5AndTopic(String MD5, Topics topic);

    Slice<Statistics> findAllByOrderByNumOfViewsDesc(Pageable pageRequest);

    Slice<Statistics> findAllByOrderByNumOfDownloadsDesc(Pageable pageRequest);

    Slice<Statistics> findAllByOrderByNumOfViewsDescNumOfDownloadsDesc(Pageable pageRequest);

    Slice<Statistics> findAllByTopicOrderByNumOfViewsDesc(Topics topic, Pageable pageRequest);
}