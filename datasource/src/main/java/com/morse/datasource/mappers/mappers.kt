package com.morse.datasource.mappers

import com.morse.datasource.models.New as RemoteNew
import com.morse.datasource.local.database.NewEntity as LocalNew
import com.morse.domain.models.New as DomainNew

fun DomainNew.asDatabaseEntity(): LocalNew = LocalNew(
    author = author ?: "-",
    title = title,
    url = url,
    urlToImage = urlToImage ?: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0zsRhugDXcl4MjVH8cj5WfDpzozMcuh8bAg&s",
    publishedAt = publishedAt,
    sourceName = sourceName
)

fun LocalNew.asDomain(): DomainNew = DomainNew(
    sourceName = sourceName,
    author = author,
    title = title,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt
)

fun RemoteNew.asDomain(): DomainNew = DomainNew(
    sourceName = source.name,
    author = author,
    title = title,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt
)