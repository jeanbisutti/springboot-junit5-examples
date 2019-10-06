package org.quickperf;

import org.quickperf.config.SpecifiableGlobalAnnotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;

import static org.quickperf.sql.annotation.SqlAnnotationBuilder.*;

/**
 * This class configures global annotations that is to say annotations applying on
 * each test.
 */
public class QuickPerfConfiguration implements SpecifiableGlobalAnnotations {

    public Collection<Annotation> specifyAnnotationsAppliedOnEachTest() {

        return Arrays.asList(
                  // Can reveal some N+1 selects
                  // https://blog.jooq.org/2017/12/18/the-cost-of-jdbc-server-roundtrips/
                  disableSameSelectTypesWithDifferentParams()

                , // Sometimes, JDBC batching can be disabled:
                  // https://abramsm.wordpress.com/2008/04/23/hibernate-batch-processing-why-you-may-not-be-using-it-even-if-you-think-you-are/
                  // https://stackoverflow.com/questions/27697810/hibernate-disabled-insert-batching-when-using-an-identity-identifier
                  expectJdbcBatching()

                , // https://use-the-index-luke.com/sql/where-clause/searching-for-ranges/like-performance-tuning
                  disableLikeWithLeadingWildcard()

                , // Can reveal a bad use of Hibernate session
                  disableExactlySameSelects()

              //, //https://vladmihalcea.com/hibernate-facts-always-check-criteria-api-sql-queries/
              //  disableCrossJoin()

        );

    }

}