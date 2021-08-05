# FEIGN-POC

POC to verify some Feign behaviours like:

- Parallel Execution
- Feign timeout requests blocking others

# Structure

## Feign-Server

Spring Boot Web Application with 1 endpoints that accepts a delay parameter that informs how much time should delay to answer response.

## Feign-Client

Spring Boot Web Application that make requests to Feign Server

# How-To Run

Run Feign-Server with the following gradle command:

```shell
cd feignpocserver; gradle bootRun
```

Run Feign-Client with the following gradle command:

```shell
cd feignpocclient; gradle bootRun
```

# Answer

- Parallel Execution

  Despite I'm using Autowired and Singleton FeignClient, each Thread did it request in parallel without problem.  

- Feign timeout requests blocking others

  Request were made non-blocking.
