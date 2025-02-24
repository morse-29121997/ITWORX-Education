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
public final class AddSelectedPreferencesUseCase_Factory implements Factory<AddSelectedPreferencesUseCase> {
  private final Provider<ISessionRepository> repoProvider;

  public AddSelectedPreferencesUseCase_Factory(Provider<ISessionRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public AddSelectedPreferencesUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static AddSelectedPreferencesUseCase_Factory create(
      Provider<ISessionRepository> repoProvider) {
    return new AddSelectedPreferencesUseCase_Factory(repoProvider);
  }

  public static AddSelectedPreferencesUseCase newInstance(ISessionRepository repo) {
    return new AddSelectedPreferencesUseCase(repo);
  }
}
