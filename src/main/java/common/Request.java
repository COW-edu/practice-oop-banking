package common;

import java.util.HashMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import view.EMenu;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Request {
  private final EMenu request;
  private final HashMap<EParamType, Object> params;

  public Object getParam(EParamType paramType){
    return params.get(paramType);
  }
}
