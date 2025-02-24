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
public final class AddSelectedCountryUseCase_Factory implements Factory<AddSelectedCountryUseCase> {
  private final Provider<ISessionRepository> repoProvider;

  public AddSelectedCountryUseCase_Factory(Provider<ISessionRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public AddSelectedCountryUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static AddSelectedCountryUseCase_Factory create(
      Provider<ISessionRepository> repoProvider) {
    return new AddSelectedCountryUseCase_Factory(repoProvider);
  }

  public static AddSelectedCountryUseCase newInstance(ISessionRepository repo) {
    return new AddSelectedCountryUseCase(repo);
  }
}
