package com.morse.domain.usecases.news;

import com.morse.domain.repositories.INewsRepository;
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
public final class AddNewsToWatchLaterUseCase_Factory implements Factory<AddNewsToWatchLaterUseCase> {
  private final Provider<INewsRepository> repoProvider;

  public AddNewsToWatchLaterUseCase_Factory(Provider<INewsRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public AddNewsToWatchLaterUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static AddNewsToWatchLaterUseCase_Factory create(Provider<INewsRepository> repoProvider) {
    return new AddNewsToWatchLaterUseCase_Factory(repoProvider);
  }

  public static AddNewsToWatchLaterUseCase newInstance(INewsRepository repo) {
    return new AddNewsToWatchLaterUseCase(repo);
  }
}
