/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.structured.content.apio.internal.architect.filter;

import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.RangeTermFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.structured.content.apio.architect.entity.EntityField;
import com.liferay.structured.content.apio.architect.filter.expression.BinaryExpression;
import com.liferay.structured.content.apio.architect.filter.expression.LiteralExpression;
import com.liferay.structured.content.apio.internal.architect.filter.expression.LiteralExpressionImpl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ruben Pulido
 */
public class ExpressionVisitorImplTest {

	@Test
	public void testVisitBinaryExpressionOperationWithAndOperation() {
		TermFilter leftTermFilter = new TermFilter("title", "title1");

		TermFilter rightTermFilter = new TermFilter("title", "title2");

		BooleanFilter booleanFilter =
			(BooleanFilter)_expressionVisitorImpl.
				visitBinaryExpressionOperation(
					BinaryExpression.Operation.AND, leftTermFilter,
					rightTermFilter);

		Assert.assertTrue(booleanFilter.hasClauses());

		List<BooleanClause<Filter>> booleanClauses =
			booleanFilter.getMustBooleanClauses();

		Assert.assertEquals(
			booleanClauses.toString(), 2, booleanClauses.size());

		BooleanClause<Filter> queryBooleanClause1 = booleanClauses.get(0);

		Assert.assertEquals(leftTermFilter, queryBooleanClause1.getClause());
		Assert.assertEquals(
			BooleanClauseOccur.MUST,
			queryBooleanClause1.getBooleanClauseOccur());

		BooleanClause<Filter> queryBooleanClause2 = booleanClauses.get(1);

		Assert.assertEquals(rightTermFilter, queryBooleanClause2.getClause());
		Assert.assertEquals(
			BooleanClauseOccur.MUST,
			queryBooleanClause2.getBooleanClauseOccur());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testVisitBinaryExpressionOperationWithEqualOperation() {
		Map<String, EntityField> entityFieldsMap =
			_structuredContentSingleEntitySchemaBasedEdmProvider.
				getEntityFieldsMap();

		EntityField entityField = entityFieldsMap.get("title");

		String value = "title1";

		TermFilter termFilter =
			(TermFilter)_expressionVisitorImpl.visitBinaryExpressionOperation(
				BinaryExpression.Operation.EQ, entityField, value);

		Assert.assertEquals(entityField.getName(), termFilter.getField());
		Assert.assertEquals(value, termFilter.getValue());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testVisitBinaryExpressionOperationWithGreaterEqualOperation() {
		Map<String, EntityField> entityFieldsMap =
			_structuredContentSingleEntitySchemaBasedEdmProvider.
				getEntityFieldsMap();

		EntityField entityField = entityFieldsMap.get("title");

		String value = "title1";

		RangeTermFilter rangeTermFilter =
			(RangeTermFilter)_expressionVisitorImpl.
				visitBinaryExpressionOperation(
					BinaryExpression.Operation.GE, entityField, value);

		Assert.assertEquals(entityField.getName(), rangeTermFilter.getField());
		Assert.assertEquals(value, rangeTermFilter.getLowerBound());
		Assert.assertNull(rangeTermFilter.getUpperBound());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testVisitBinaryExpressionOperationWithLowerEqualOperation() {
		Map<String, EntityField> entityFieldsMap =
			_structuredContentSingleEntitySchemaBasedEdmProvider.
				getEntityFieldsMap();

		EntityField entityField = entityFieldsMap.get("title");

		String value = "title1";

		RangeTermFilter rangeTermFilter =
			(RangeTermFilter)_expressionVisitorImpl.
				visitBinaryExpressionOperation(
					BinaryExpression.Operation.LE, entityField, value);

		Assert.assertEquals(entityField.getName(), rangeTermFilter.getField());
		Assert.assertEquals(value, rangeTermFilter.getUpperBound());
		Assert.assertNull(rangeTermFilter.getLowerBound());
	}

	@Test
	public void testVisitBinaryExpressionOperationWithOrOperation() {
		TermFilter leftTermFilter = new TermFilter("title", "title1");

		TermFilter rightTermFilter = new TermFilter("title", "title2");

		BooleanFilter booleanFilter =
			(BooleanFilter)_expressionVisitorImpl.
				visitBinaryExpressionOperation(
					BinaryExpression.Operation.OR, leftTermFilter,
					rightTermFilter);

		Assert.assertTrue(booleanFilter.hasClauses());

		List<BooleanClause<Filter>> booleanClauses =
			booleanFilter.getShouldBooleanClauses();

		Assert.assertEquals(
			booleanClauses.toString(), 2, booleanClauses.size());

		BooleanClause<Filter> queryBooleanClause1 = booleanClauses.get(0);

		Assert.assertEquals(leftTermFilter, queryBooleanClause1.getClause());
		Assert.assertEquals(
			BooleanClauseOccur.SHOULD,
			queryBooleanClause1.getBooleanClauseOccur());

		BooleanClause<Filter> queryBooleanClause2 = booleanClauses.get(1);

		Assert.assertEquals(rightTermFilter, queryBooleanClause2.getClause());
		Assert.assertEquals(
			BooleanClauseOccur.SHOULD,
			queryBooleanClause2.getBooleanClauseOccur());
	}

	@Test
	public void testVisitLiteralExpressionWithDoubleSingleQuotes() {
		LiteralExpression literalExpression = new LiteralExpressionImpl(
			"'L''Oreal'", LiteralExpression.Type.STRING);

		Assert.assertEquals(
			"l'oreal",
			_expressionVisitorImpl.visitLiteralExpression(literalExpression));
	}

	@Test
	public void testVisitLiteralExpressionWithMultipleDoubleSingleQuotes() {
		LiteralExpression literalExpression = new LiteralExpressionImpl(
			"'L''Oreal and L''Oreal'", LiteralExpression.Type.STRING);

		Assert.assertEquals(
			"l'oreal and l'oreal",
			_expressionVisitorImpl.visitLiteralExpression(literalExpression));
	}

	@Test
	public void testVisitLiteralExpressionWithOneSingleQuote() {
		LiteralExpression literalExpression = new LiteralExpressionImpl(
			"'L'Oreal'", LiteralExpression.Type.STRING);

		Assert.assertEquals(
			"l'oreal",
			_expressionVisitorImpl.visitLiteralExpression(literalExpression));
	}

	@Test
	public void testVisitLiteralExpressionWithSurroundingSingleQuotes() {
		LiteralExpression literalExpression = new LiteralExpressionImpl(
			"'LOreal'", LiteralExpression.Type.STRING);

		Assert.assertEquals(
			"loreal",
			_expressionVisitorImpl.visitLiteralExpression(literalExpression));
	}

	private static final ExpressionVisitorImpl _expressionVisitorImpl =
		new ExpressionVisitorImpl(
			LocaleUtil.getDefault(),
			ExpressionVisitorImplTest.
				_structuredContentSingleEntitySchemaBasedEdmProvider);

	private static final StructuredContentSingleEntitySchemaBasedEdmProvider
		_structuredContentSingleEntitySchemaBasedEdmProvider =
			new StructuredContentSingleEntitySchemaBasedEdmProvider() {

				@Override
				public Map<String, EntityField> getEntityFieldsMap() {
					return Stream.of(
						new EntityField(
							"title", EntityField.Type.STRING, locale -> "title")
					).collect(
						Collectors.toMap(
							EntityField::getName, Function.identity())
					);
				}

				@Override
				public String getName() {
					return "SomeEntityName";
				}

			};

}