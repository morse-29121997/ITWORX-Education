package com.morse.domain.usecases.onboarding;

import com.morse.domain.repositories.ISessionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class GetSelectedCountryUseCase_Factory implements Factory<GetSelectedCountryUseCase> {
  private final Provider<ISessionRepository> repoProvider;

  public GetSelectedCountryUseCase_Factory(Provider<ISessionRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetSelectedCountryUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetSelectedCountryUseCase_Factory create(
      Provider<ISessionRepository> repoProvider) {
    return new GetSelectedCountryUseCase_Factory(repoProvider);
  }

  public static GetSelectedCountryUseCase newInstance(ISessionRepository repo) {
    return new GetSelectedCountryUseCase(repo);
  }
}
