package io.github.matheusfy.desafio_pickpay.desafio_pickpay.authorization;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizationService {

  private RestClient client;

  public AuthorizationService(RestClient.Builder clientBuilder) {
    this.client = clientBuilder
        .baseUrl("https://util.devi.tools/api/v2/authorize")
        .build();
  }

  public void authorize() {
    var response = client.get()
        .retrieve()
        .toEntity(Authorization.class);

    if (response.getStatusCode().isError() || !response.getBody().data().isAuthorized()) {
      throw new RuntimeException("Transação não autorizada.");
    }
  }
}
