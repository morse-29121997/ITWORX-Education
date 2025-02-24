package com.morse.news.app;

import android.app.Activity;
import android.app.Service;
import android.content.SharedPreferences;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.morse.datasource.di.CoroutinesDispatchersModule_ProvidesIoDispatcherFactory;
import com.morse.datasource.di.CoroutinesScopesModule_ProvidesCoroutineScopeFactory;
import com.morse.datasource.di.DataSourceModule_ProvideAppDatabaseFactory;
import com.morse.datasource.di.DataSourceModule_ProvideNewsAPIsFactory;
import com.morse.datasource.di.DataSourceModule_ProvideNewsDaoFactory;
import com.morse.datasource.di.DataSourceModule_ProvideNewsRepositoryFactory;
import com.morse.datasource.di.DataSourceModule_ProvideNewsSharedPreferenceFactory;
import com.morse.datasource.di.DataSourceModule_ProvideOkHttpBuilderFactory;
import com.morse.datasource.di.DataSourceModule_ProvideRetrofitFactory;
import com.morse.datasource.di.DataSourceModule_ProvideSessionRepositoryFactory;
import com.morse.datasource.di.DataSourceModule_ProvideSharedPreferencesFactory;
import com.morse.datasource.local.database.NewsDao;
import com.morse.datasource.local.database.NewsDataBase;
import com.morse.datasource.local.preference.NewsPreferenceManager;
import com.morse.datasource.remote.NewsApis;
import com.morse.domain.repositories.INewsRepository;
import com.morse.domain.repositories.ISessionRepository;
import com.morse.domain.usecases.news.AddNewsToWatchLaterUseCase;
import com.morse.domain.usecases.news.DeleteNewsFromWatchLaterUseCase;
import com.morse.domain.usecases.news.GetAllNewsInWatchLaterUseCase;
import com.morse.domain.usecases.news.GetAllNewsUseCase;
import com.morse.domain.usecases.news.GetHeadlineNewsUseCase;
import com.morse.domain.usecases.onboarding.AddIsUserFirstTimeToAddPreferencesUseCase;
import com.morse.domain.usecases.onboarding.AddSelectedCountryUseCase;
import com.morse.domain.usecases.onboarding.AddSelectedPreferencesUseCase;
import com.morse.domain.usecases.onboarding.GetIsUserFirstTimeToAddPreferencesUseCase;
import com.morse.domain.usecases.onboarding.GetSelectedCountryUseCase;
import com.morse.domain.usecases.onboarding.GetSelectedPreferencesUseCase;
import com.morse.news.feature_news.view_all_news.NewsViewModel;
import com.morse.news.feature_news.view_all_news.NewsViewModel_HiltModules;
import com.morse.news.feature_news.view_saved_news.SavedViewModel;
import com.morse.news.feature_news.view_saved_news.SavedViewModel_HiltModules;
import com.morse.news.feature_search.SearchViewModel;
import com.morse.news.feature_search.SearchViewModel_HiltModules;
import com.morse.news.launcher.MainActivity;
import com.morse.onboarding.preferences.PreferencesViewModel;
import com.morse.onboarding.preferences.PreferencesViewModel_HiltModules;
import com.morse.onboarding.splash.SplashViewModel;
import com.morse.onboarding.splash.SplashViewModel_HiltModules;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Retrofit;

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
public final class DaggerNewsApp_HiltComponents_SingletonC {
  private DaggerNewsApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public NewsApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements NewsApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public NewsApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements NewsApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public NewsApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements NewsApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public NewsApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements NewsApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public NewsApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements NewsApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public NewsApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements NewsApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public NewsApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements NewsApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public NewsApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends NewsApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends NewsApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends NewsApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends NewsApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(5).put(LazyClassKeyProvider.com_morse_news_feature_news_view_all_news_NewsViewModel, NewsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_morse_onboarding_preferences_PreferencesViewModel, PreferencesViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_morse_news_feature_news_view_saved_news_SavedViewModel, SavedViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_morse_news_feature_search_SearchViewModel, SearchViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_morse_onboarding_splash_SplashViewModel, SplashViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_morse_onboarding_splash_SplashViewModel = "com.morse.onboarding.splash.SplashViewModel";

      static String com_morse_onboarding_preferences_PreferencesViewModel = "com.morse.onboarding.preferences.PreferencesViewModel";

      static String com_morse_news_feature_news_view_all_news_NewsViewModel = "com.morse.news.feature_news.view_all_news.NewsViewModel";

      static String com_morse_news_feature_search_SearchViewModel = "com.morse.news.feature_search.SearchViewModel";

      static String com_morse_news_feature_news_view_saved_news_SavedViewModel = "com.morse.news.feature_news.view_saved_news.SavedViewModel";

      @KeepFieldType
      SplashViewModel com_morse_onboarding_splash_SplashViewModel2;

      @KeepFieldType
      PreferencesViewModel com_morse_onboarding_preferences_PreferencesViewModel2;

      @KeepFieldType
      NewsViewModel com_morse_news_feature_news_view_all_news_NewsViewModel2;

      @KeepFieldType
      SearchViewModel com_morse_news_feature_search_SearchViewModel2;

      @KeepFieldType
      SavedViewModel com_morse_news_feature_news_view_saved_news_SavedViewModel2;
    }
  }

  private static final class ViewModelCImpl extends NewsApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<NewsViewModel> newsViewModelProvider;

    private Provider<PreferencesViewModel> preferencesViewModelProvider;

    private Provider<SavedViewModel> savedViewModelProvider;

    private Provider<SearchViewModel> searchViewModelProvider;

    private Provider<SplashViewModel> splashViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    private GetSelectedCountryUseCase getSelectedCountryUseCase() {
      return new GetSelectedCountryUseCase(singletonCImpl.provideSessionRepositoryProvider.get());
    }

    private GetSelectedPreferencesUseCase getSelectedPreferencesUseCase() {
      return new GetSelectedPreferencesUseCase(singletonCImpl.provideSessionRepositoryProvider.get());
    }

    private GetAllNewsUseCase getAllNewsUseCase() {
      return new GetAllNewsUseCase(singletonCImpl.provideNewsRepositoryProvider.get());
    }

    private GetHeadlineNewsUseCase getHeadlineNewsUseCase() {
      return new GetHeadlineNewsUseCase(singletonCImpl.provideNewsRepositoryProvider.get());
    }

    private AddNewsToWatchLaterUseCase addNewsToWatchLaterUseCase() {
      return new AddNewsToWatchLaterUseCase(singletonCImpl.provideNewsRepositoryProvider.get());
    }

    private DeleteNewsFromWatchLaterUseCase deleteNewsFromWatchLaterUseCase() {
      return new DeleteNewsFromWatchLaterUseCase(singletonCImpl.provideNewsRepositoryProvider.get());
    }

    private GetAllNewsInWatchLaterUseCase getAllNewsInWatchLaterUseCase() {
      return new GetAllNewsInWatchLaterUseCase(singletonCImpl.provideNewsRepositoryProvider.get());
    }

    private AddSelectedCountryUseCase addSelectedCountryUseCase() {
      return new AddSelectedCountryUseCase(singletonCImpl.provideSessionRepositoryProvider.get());
    }

    private AddSelectedPreferencesUseCase addSelectedPreferencesUseCase() {
      return new AddSelectedPreferencesUseCase(singletonCImpl.provideSessionRepositoryProvider.get());
    }

    private AddIsUserFirstTimeToAddPreferencesUseCase addIsUserFirstTimeToAddPreferencesUseCase() {
      return new AddIsUserFirstTimeToAddPreferencesUseCase(singletonCImpl.provideSessionRepositoryProvider.get());
    }

    private GetIsUserFirstTimeToAddPreferencesUseCase getIsUserFirstTimeToAddPreferencesUseCase() {
      return new GetIsUserFirstTimeToAddPreferencesUseCase(singletonCImpl.provideSessionRepositoryProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.newsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.preferencesViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.savedViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.searchViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.splashViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(5).put(LazyClassKeyProvider.com_morse_news_feature_news_view_all_news_NewsViewModel, ((Provider) newsViewModelProvider)).put(LazyClassKeyProvider.com_morse_onboarding_preferences_PreferencesViewModel, ((Provider) preferencesViewModelProvider)).put(LazyClassKeyProvider.com_morse_news_feature_news_view_saved_news_SavedViewModel, ((Provider) savedViewModelProvider)).put(LazyClassKeyProvider.com_morse_news_feature_search_SearchViewModel, ((Provider) searchViewModelProvider)).put(LazyClassKeyProvider.com_morse_onboarding_splash_SplashViewModel, ((Provider) splashViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_morse_onboarding_preferences_PreferencesViewModel = "com.morse.onboarding.preferences.PreferencesViewModel";

      static String com_morse_news_feature_search_SearchViewModel = "com.morse.news.feature_search.SearchViewModel";

      static String com_morse_news_feature_news_view_saved_news_SavedViewModel = "com.morse.news.feature_news.view_saved_news.SavedViewModel";

      static String com_morse_news_feature_news_view_all_news_NewsViewModel = "com.morse.news.feature_news.view_all_news.NewsViewModel";

      static String com_morse_onboarding_splash_SplashViewModel = "com.morse.onboarding.splash.SplashViewModel";

      @KeepFieldType
      PreferencesViewModel com_morse_onboarding_preferences_PreferencesViewModel2;

      @KeepFieldType
      SearchViewModel com_morse_news_feature_search_SearchViewModel2;

      @KeepFieldType
      SavedViewModel com_morse_news_feature_news_view_saved_news_SavedViewModel2;

      @KeepFieldType
      NewsViewModel com_morse_news_feature_news_view_all_news_NewsViewModel2;

      @KeepFieldType
      SplashViewModel com_morse_onboarding_splash_SplashViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.morse.news.feature_news.view_all_news.NewsViewModel 
          return (T) new NewsViewModel(viewModelCImpl.getSelectedCountryUseCase(), viewModelCImpl.getSelectedPreferencesUseCase(), viewModelCImpl.getAllNewsUseCase(), viewModelCImpl.getHeadlineNewsUseCase(), viewModelCImpl.addNewsToWatchLaterUseCase(), viewModelCImpl.deleteNewsFromWatchLaterUseCase(), viewModelCImpl.getAllNewsInWatchLaterUseCase());

          case 1: // com.morse.onboarding.preferences.PreferencesViewModel 
          return (T) new PreferencesViewModel(viewModelCImpl.addSelectedCountryUseCase(), viewModelCImpl.addSelectedPreferencesUseCase(), viewModelCImpl.addIsUserFirstTimeToAddPreferencesUseCase());

          case 2: // com.morse.news.feature_news.view_saved_news.SavedViewModel 
          return (T) new SavedViewModel(viewModelCImpl.getAllNewsInWatchLaterUseCase(), viewModelCImpl.addNewsToWatchLaterUseCase(), viewModelCImpl.deleteNewsFromWatchLaterUseCase());

          case 3: // com.morse.news.feature_search.SearchViewModel 
          return (T) new SearchViewModel(viewModelCImpl.getSelectedCountryUseCase(), viewModelCImpl.getSelectedPreferencesUseCase(), viewModelCImpl.getHeadlineNewsUseCase(), viewModelCImpl.addNewsToWatchLaterUseCase(), viewModelCImpl.deleteNewsFromWatchLaterUseCase(), viewModelCImpl.getAllNewsInWatchLaterUseCase());

          case 4: // com.morse.onboarding.splash.SplashViewModel 
          return (T) new SplashViewModel(viewModelCImpl.getIsUserFirstTimeToAddPreferencesUseCase());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends NewsApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends NewsApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends NewsApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<SharedPreferences> provideSharedPreferencesProvider;

    private Provider<NewsPreferenceManager> provideNewsSharedPreferenceProvider;

    private Provider<ISessionRepository> provideSessionRepositoryProvider;

    private Provider<okhttp3.OkHttpClient.Builder> provideOkHttpBuilderProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<NewsApis> provideNewsAPIsProvider;

    private Provider<NewsDataBase> provideAppDatabaseProvider;

    private Provider<CoroutineScope> providesCoroutineScopeProvider;

    private Provider<INewsRepository> provideNewsRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private NewsDao newsDao() {
      return DataSourceModule_ProvideNewsDaoFactory.provideNewsDao(provideAppDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideSharedPreferencesProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferences>(singletonCImpl, 2));
      this.provideNewsSharedPreferenceProvider = DoubleCheck.provider(new SwitchingProvider<NewsPreferenceManager>(singletonCImpl, 1));
      this.provideSessionRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ISessionRepository>(singletonCImpl, 0));
      this.provideOkHttpBuilderProvider = DoubleCheck.provider(new SwitchingProvider<okhttp3.OkHttpClient.Builder>(singletonCImpl, 6));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 5));
      this.provideNewsAPIsProvider = DoubleCheck.provider(new SwitchingProvider<NewsApis>(singletonCImpl, 4));
      this.provideAppDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<NewsDataBase>(singletonCImpl, 7));
      this.providesCoroutineScopeProvider = DoubleCheck.provider(new SwitchingProvider<CoroutineScope>(singletonCImpl, 8));
      this.provideNewsRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<INewsRepository>(singletonCImpl, 3));
    }

    @Override
    public void injectNewsApp(NewsApp newsApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.morse.domain.repositories.ISessionRepository 
          return (T) DataSourceModule_ProvideSessionRepositoryFactory.provideSessionRepository(singletonCImpl.provideNewsSharedPreferenceProvider.get());

          case 1: // com.morse.datasource.local.preference.NewsPreferenceManager 
          return (T) DataSourceModule_ProvideNewsSharedPreferenceFactory.provideNewsSharedPreference(singletonCImpl.provideSharedPreferencesProvider.get());

          case 2: // android.content.SharedPreferences 
          return (T) DataSourceModule_ProvideSharedPreferencesFactory.provideSharedPreferences(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // com.morse.domain.repositories.INewsRepository 
          return (T) DataSourceModule_ProvideNewsRepositoryFactory.provideNewsRepository(singletonCImpl.provideNewsAPIsProvider.get(), singletonCImpl.newsDao(), singletonCImpl.providesCoroutineScopeProvider.get());

          case 4: // com.morse.datasource.remote.NewsApis 
          return (T) DataSourceModule_ProvideNewsAPIsFactory.provideNewsAPIs(singletonCImpl.provideRetrofitProvider.get());

          case 5: // retrofit2.Retrofit 
          return (T) DataSourceModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.provideOkHttpBuilderProvider.get());

          case 6: // okhttp3.OkHttpClient.Builder 
          return (T) DataSourceModule_ProvideOkHttpBuilderFactory.provideOkHttpBuilder();

          case 7: // com.morse.datasource.local.database.NewsDataBase 
          return (T) DataSourceModule_ProvideAppDatabaseFactory.provideAppDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 8: // kotlinx.coroutines.CoroutineScope 
          return (T) CoroutinesScopesModule_ProvidesCoroutineScopeFactory.providesCoroutineScope(CoroutinesDispatchersModule_ProvidesIoDispatcherFactory.providesIoDispatcher());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
