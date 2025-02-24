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
public final class GetHeadlineNewsUseCase_Factory implements Factory<GetHeadlineNewsUseCase> {
  private final Provider<INewsRepository> repoProvider;

  public GetHeadlineNewsUseCase_Factory(Provider<INewsRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetHeadlineNewsUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetHeadlineNewsUseCase_Factory create(Provider<INewsRepository> repoProvider) {
    return new GetHeadlineNewsUseCase_Factory(repoProvider);
  }

  public static GetHeadlineNewsUseCase newInstance(INewsRepository repo) {
    return new GetHeadlineNewsUseCase(repo);
  }
}
