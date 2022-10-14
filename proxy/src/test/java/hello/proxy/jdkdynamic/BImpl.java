package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface {
    public String call(){
      log.info("B호출");
      return "a";
    };

}
