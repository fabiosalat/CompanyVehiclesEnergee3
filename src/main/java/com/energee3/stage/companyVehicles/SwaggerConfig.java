package com.energee3.stage.companyVehicles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.energee3.stage.companyVehicles.model.Bookings;
import com.energee3.stage.companyVehicles.model.Employees;
import com.energee3.stage.companyVehicles.model.Manufacturer;
import com.energee3.stage.companyVehicles.model.Model;
import com.energee3.stage.companyVehicles.model.Utilization;
import com.energee3.stage.companyVehicles.model.Vehicles;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.energee3.stage.companyVehicles.controller"))
					.paths(PathSelectors.any()).build().apiInfo(getInfo())
					.ignoredParameterTypes(Model.class, Bookings.class, Employees.class, Manufacturer.class, Utilization.class, Vehicles.class);
	}
	
	private ApiInfo getInfo() {
		return new ApiInfoBuilder().title("Company Vehicles")
				.description("Api Documentation of Company Vehicles project @Energee3")
				.version("1.0")
				.termsOfServiceUrl("url:ToS")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
}
