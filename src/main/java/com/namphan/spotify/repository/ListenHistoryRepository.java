package com.namphan.spotify.repository;

import com.namphan.spotify.dto.ListenHistoryDTO;
import com.namphan.spotify.entity.Album;
import com.namphan.spotify.entity.ListenHistory;
import com.namphan.spotify.request.MostTimesInWeekbySongId;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ListenHistoryRepository extends JpaRepository<ListenHistory,Integer> {
    @Query(value = "WITH RankedListenHistory AS (\n" +
            "    SELECT \n" +
            "        song_id,\n" +
            "        DATEPART(WEEK, timestamp) AS week_number,\n" +
            "        COUNT(*) AS listens_per_week,\n" +
            "        ROW_NUMBER() OVER (PARTITION BY DATEPART(WEEK, timestamp), song_id ORDER BY COUNT(*) DESC) AS rn\n" +
            "    FROM listen_history\n" +
            "    WHERE DATEPART(WEEK, timestamp) = DATEPART(WEEK, GETDATE()) -- Chỉ lấy dữ liệu cho tuần hiện tại\n" +
            "    GROUP BY DATEPART(WEEK, timestamp), song_id\n" +
            ")\n" +
            "\n" +
            "SELECT \n" +
            "    song_id,\n" +
            "    week_number,\n" +
            "    listens_per_week\n" +
            "FROM RankedListenHistory\n" +
            "WHERE rn = 1;", nativeQuery = true)
    List<Tuple> MostTimesInWeekbySongId();
}
