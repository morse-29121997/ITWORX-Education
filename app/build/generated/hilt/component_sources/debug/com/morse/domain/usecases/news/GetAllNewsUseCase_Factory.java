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
public final class GetAllNewsUseCase_Factory implements Factory<GetAllNewsUseCase> {
  private final Provider<INewsRepository> repoProvider;

  public GetAllNewsUseCase_Factory(Provider<INewsRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetAllNewsUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetAllNewsUseCase_Factory create(Provider<INewsRepository> repoProvider) {
    return new GetAllNewsUseCase_Factory(repoProvider);
  }

  public static GetAllNewsUseCase newInstance(INewsRepository repo) {
    return new GetAllNewsUseCase(repo);
  }
}
