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
public final class DeleteNewsFromWatchLaterUseCase_Factory implements Factory<DeleteNewsFromWatchLaterUseCase> {
  private final Provider<INewsRepository> repoProvider;

  public DeleteNewsFromWatchLaterUseCase_Factory(Provider<INewsRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public DeleteNewsFromWatchLaterUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static DeleteNewsFromWatchLaterUseCase_Factory create(
      Provider<INewsRepository> repoProvider) {
    return new DeleteNewsFromWatchLaterUseCase_Factory(repoProvider);
  }

  public static DeleteNewsFromWatchLaterUseCase newInstance(INewsRepository repo) {
    return new DeleteNewsFromWatchLaterUseCase(repo);
  }
}
