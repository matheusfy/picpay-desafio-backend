package io.github.matheusfy.desafio_pickpay.desafio_pickpay.authorization;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.authorization.exception.NonAuthorizedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizationService {

  private final RestClient client;
  private final Logger logger = LogManager.getLogger();

  public AuthorizationService(RestClient.Builder clientBuilder) {
    this.client = clientBuilder
        .baseUrl("https://util.devi.tools/api/v2/authorize")
        .build();
  }

  public void authorize() {
      try{
        var response = client.get()
            .retrieve()
            .toEntity(Authorization.class);

        if (response.getStatusCode().isError() || !response.getBody().data().isAuthorized()) {
            logger.warn("Transaction not authorized.");
          throw new NonAuthorizedException("Transaction not authorized.");
        }
      } catch (Exception e){
          throw new RuntimeException(e.getMessage());
      }


    logger.info("Transaction authorized.");
  }
}
