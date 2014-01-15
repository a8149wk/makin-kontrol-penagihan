package app.mkp.adfextensions;

import oracle.jbo.ApplicationModule;

public interface CustomApplicationModule extends ApplicationModule{
  void callProcWithNoArgs();
}
