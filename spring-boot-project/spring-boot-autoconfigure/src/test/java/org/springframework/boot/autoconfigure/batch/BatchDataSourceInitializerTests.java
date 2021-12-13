/*
 * Copyright 2012-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.batch;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import org.springframework.core.io.DefaultResourceLoader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

/**
 * Tests for {@link BatchDataSourceInitializer}.
 *
 * @author Stephane Nicoll
 */
class BatchDataSourceInitializerTests {

	@Test
	void getDatabaseNameWithPlatformDoesNotTouchDataSource() {
		DataSource dataSource = mock(DataSource.class);
		BatchProperties properties = new BatchProperties();
		properties.getJdbc().setPlatform("test");
		BatchDataSourceInitializer initializer = new BatchDataSourceInitializer(dataSource, new DefaultResourceLoader(),
				properties);
		assertThat(initializer.getDatabaseName()).isEqualTo("test");
		verifyNoInteractions(dataSource);
	}

}
