package org.lotzy.sample.multidb.db2.dao;

import org.lotzy.sample.multidb.db2.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Title: VideoRepository interface
 * Description: JPA Repository interface declaration for Video entities
 * </pre>
 *
 * @author Lotzy (lotzy_l@yahoo.com)
 * @version 1.0
 */
public interface VideoRepository extends JpaRepository<Video, Long> {

}
