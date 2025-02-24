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
public final class AddIsUserFirstTimeToAddPreferencesUseCase_Factory implements Factory<AddIsUserFirstTimeToAddPreferencesUseCase> {
  private final Provider<ISessionRepository> repoProvider;

  public AddIsUserFirstTimeToAddPreferencesUseCase_Factory(
      Provider<ISessionRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public AddIsUserFirstTimeToAddPreferencesUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static AddIsUserFirstTimeToAddPreferencesUseCase_Factory create(
      Provider<ISessionRepository> repoProvider) {
    return new AddIsUserFirstTimeToAddPreferencesUseCase_Factory(repoProvider);
  }

  public static AddIsUserFirstTimeToAddPreferencesUseCase newInstance(ISessionRepository repo) {
    return new AddIsUserFirstTimeToAddPreferencesUseCase(repo);
  }
}
