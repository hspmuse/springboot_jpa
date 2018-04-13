# springboot_jpa_groovy_sql

pom.xml - groovy설정
-------------
        <dependency>
			<groupId>org.codehaus.groovy</groupId>
			<artifactId>groovy-all</artifactId>
		</dependency>
		
			<!-- groovy complie -->
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<!-- 2.8.0-01 and later require maven-compiler-plugin 3.1 or higher -->
				<version>3.1</version>
				<configuration>
					<compilerId>groovy-eclipse-compiler</compilerId>
				</configuration>
				<dependencies>
					<dependency>
						<groupId>org.codehaus.groovy</groupId>
						<artifactId>groovy-eclipse-compiler</artifactId>
						<version>2.9.2-01</version>
					</dependency>
					<!-- for 2.8.0-01 and later you must have an explicit dependency on groovy-eclipse-batch -->
					<dependency>
						<groupId>org.codehaus.groovy</groupId>
						<artifactId>groovy-eclipse-batch</artifactId>
						<version>2.4.3-01</version>
					</dependency>
				</dependencies>
			</plugin>
--------------

