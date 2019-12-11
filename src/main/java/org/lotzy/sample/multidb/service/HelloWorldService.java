/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lotzy.sample.multidb.service;

import java.util.Date;

import org.lotzy.sample.multidb.db1.dao.UserRepository;
import org.lotzy.sample.multidb.db1.entity.User;
import org.lotzy.sample.multidb.db2.dao.VideoRepository;
import org.lotzy.sample.multidb.db2.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Title: HelloWorldService class
 * Description: Service class that will use JPA repositories to do some DB operations
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@Service
public class HelloWorldService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private VideoRepository videoRepo;

	public String getHelloMessage() {

		User user = new User();
		user.setUserId(1L);
		user.setName("TestName");
		user.setSurname("TestSurname");
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		User savedUser = userRepo.save(user);

		Video video = new Video();
		video.setVideoId(1L);
		video.setBitrate(128);
		video.setLength(120);
		video.setTitle("Test");
		Video savedVideo = videoRepo.save(video);

		return "Hello world video " + savedVideo.getTitle() + " from " + savedUser.getName();
	}

}
