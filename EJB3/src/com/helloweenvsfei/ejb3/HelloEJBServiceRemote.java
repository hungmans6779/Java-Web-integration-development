package com.helloweenvsfei.ejb3;

import javax.ejb.Remote;

@Remote
public interface HelloEJBServiceRemote {
  public String sayHelloEJB(String name);
}
