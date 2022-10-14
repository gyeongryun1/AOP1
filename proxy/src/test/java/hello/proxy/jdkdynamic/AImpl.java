package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface {
    public String call(){
      log.info("A호출");
      return "a";
    };

}
