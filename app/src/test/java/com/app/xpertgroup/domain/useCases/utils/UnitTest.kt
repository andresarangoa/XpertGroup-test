package com.app.xpertgroup.domain.useCases.utils

import org.junit.Rule

abstract class UnitTest {

    @Suppress("LeakingThis")
    @Rule
    @JvmField val injectMocks = InjectMocksRule.create(this@UnitTest)

}
