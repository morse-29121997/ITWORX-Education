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
public final class GetSelectedPreferencesUseCase_Factory implements Factory<GetSelectedPreferencesUseCase> {
  private final Provider<ISessionRepository> repoProvider;

  public GetSelectedPreferencesUseCase_Factory(Provider<ISessionRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetSelectedPreferencesUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetSelectedPreferencesUseCase_Factory create(
      Provider<ISessionRepository> repoProvider) {
    return new GetSelectedPreferencesUseCase_Factory(repoProvider);
  }

  public static GetSelectedPreferencesUseCase newInstance(ISessionRepository repo) {
    return new GetSelectedPreferencesUseCase(repo);
  }
}
