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
public final class GetAllNewsInWatchLaterUseCase_Factory implements Factory<GetAllNewsInWatchLaterUseCase> {
  private final Provider<INewsRepository> repoProvider;

  public GetAllNewsInWatchLaterUseCase_Factory(Provider<INewsRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetAllNewsInWatchLaterUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetAllNewsInWatchLaterUseCase_Factory create(
      Provider<INewsRepository> repoProvider) {
    return new GetAllNewsInWatchLaterUseCase_Factory(repoProvider);
  }

  public static GetAllNewsInWatchLaterUseCase newInstance(INewsRepository repo) {
    return new GetAllNewsInWatchLaterUseCase(repo);
  }
}
